package com.org.inventory.service;

import com.org.inventory.dto.InventorySearchRequest;
import com.org.inventory.entity.Inventory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventorySpecification {

    public static Specification<Inventory> withFilters(InventorySearchRequest req) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            Optional.ofNullable(req.name())
                    .filter(s -> !s.isBlank())
                    .ifPresent(name ->
                            predicates.add(
                                    cb.like(
                                            cb.lower(root.get("name")),
                                            "%" + name.toLowerCase() + "%"
                                    )
                            ));

            Optional.ofNullable(req.category())
                    .ifPresent(cat ->
                            predicates.add(
                                    cb.equal(root.get("category"), cat)
                            ));

            Optional.ofNullable(req.minPrice())
                    .ifPresent(min ->
                            predicates.add(
                                    cb.greaterThanOrEqualTo(root.get("price"), min)
                            ));

            Optional.ofNullable(req.maxPrice())
                    .ifPresent(max ->
                            predicates.add(
                                    cb.lessThanOrEqualTo(root.get("price"), max)
                            ));

            Optional.ofNullable(req.manufacturedFrom())
                    .ifPresent(date ->
                            predicates.add(
                                    cb.greaterThanOrEqualTo(
                                            root.get("manufacturingDate"), date
                                    )
                            ));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}