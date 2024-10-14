package br.com.fiap.residex.repository;

import br.com.fiap.residex.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
