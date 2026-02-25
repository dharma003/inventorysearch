//package com.org.inventory;
//
//import com.org.inventory.entity.Inventory;
//import com.org.inventory.repository.InventoryRepository;
//import com.org.inventory.service.InventoryService;
//import com.org.inventory.specification.InventorySpecification;
//import com.org.inventory.web.dto.InventorySearchRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
//class InventoryServiceTest {
//
//    @Mock
//    private InventoryRepository repository;
//
//    @InjectMocks
//    private InventoryService service;
//
//    private Inventory inventory;
//
//    @BeforeEach
//    void setup() {
//        inventory = new Inventory();
//        inventory.setId(UUID.randomUUID());
//        inventory.setName("Laptop");
//        inventory.setPrice(BigDecimal.valueOf(50000));
//        inventory.setStock(10);
//    }
//
//    @Test
//    void searchInventory_shouldReturnMatchingRecords() {
//        // Given
//        InventorySearchRequest request = new InventorySearchRequest(
//                "Laptop",
//                null,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null,
//                BigDecimal.valueOf(10000),
//                BigDecimal.valueOf(60000),
//                null,
//                null,
//                null
//        );
//
//        when(repository.findAll(any(Specification.class)))
//                .thenReturn(List.of(inventory));
//
//        // When
//        List<Inventory> result = service.search(request);
//
//        // Then
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getName()).isEqualTo("Laptop");
//
//        verify(repository, times(1)).findAll(any(Specification.class));
//    }
//}