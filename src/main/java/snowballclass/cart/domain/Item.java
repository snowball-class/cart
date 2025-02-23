package snowballclass.cart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    private Long lessonId;

    private LocalDate createdAt = LocalDate.now();

    private Boolean deleted = false;

    private LocalDate deletedAt = null;

    public Item(Cart cart, Long lessonId) {
        this.cart = cart;
        this.lessonId = lessonId;
        this.createdAt = LocalDate.now();
        this.deleted = false;
        this.deletedAt = null;
    }

    static public Item create(Cart cart, Long lessonId) {
        return new Item(cart,lessonId);
    }

    public void remove() {
        this.deleted = true;
        this.deletedAt = LocalDate.now();
    }
}
