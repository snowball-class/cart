package snowballclass.cart.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Long classId;

    private LocalDate createdAt = LocalDate.now();

    private Boolean deleted = false;

    private LocalDate deletedAt = null;
}
