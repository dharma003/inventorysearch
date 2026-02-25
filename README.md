# Inventory Search Microservice

## Tech Stack
- Spring Boot 3.x
- PostgreSQL
- Spring Data JPA (Specification Pattern)
- OpenAPI 3.0
- Maven

---

## Design Approach

1. All search filters are optional.
2. Filters are combined using AND conditions.
3. Dynamic filtering implemented using JPA Specification.
4. Pagination and sorting supported.
5. Indexed DB columns for optimized query performance.
6. Partial search implemented using ILIKE.
7. UUID used as primary key.
8. Validation annotations ensure valid ranges.

---

## Assumptions

- If no filters provided → return paginated full inventory.
- Price and stock cannot be negative.
- Date ranges must be logical (manufacturedFrom <= manufacturedTo).

---

## Performance Considerations

- Indexes added on frequently filtered columns.
- Pagination mandatory for large datasets.
- Query optimized using dynamic predicate building.
- Recommended: add GIN index for full-text search if needed.

---

## Future Enhancements

- ElasticSearch integration for advanced search
- Caching layer (Redis) - production
- Caching layer (caffeine) - dev
- Soft delete support
- Audit trail
- Multi-tenant support
