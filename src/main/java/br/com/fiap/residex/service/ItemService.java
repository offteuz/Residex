package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.ItemCadastroDto;
import br.com.fiap.residex.dto.exibicao.ItemExibicaoDto;
import br.com.fiap.residex.model.Item;
import br.com.fiap.residex.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private Item item;

    @Autowired
    private ItemRepository itemRepository;

    public ItemExibicaoDto create(ItemCadastroDto itemCadastroDto){

        BeanUtils.copyProperties(item, itemCadastroDto);

        return new ItemExibicaoDto(itemRepository.save(item));
    }
}
