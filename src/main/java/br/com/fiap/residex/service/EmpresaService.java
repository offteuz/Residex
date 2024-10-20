package br.com.fiap.residex.service;

import br.com.fiap.residex.dto.cadastro.EmpresaCadastroDto;
import br.com.fiap.residex.dto.cadastro.EmpresaUpdateDto;
import br.com.fiap.residex.dto.exibicao.EmpresaExibicaoDto;
import br.com.fiap.residex.dto.exibicao.EmpresaSemCaminhoesExibicaoDto;
import br.com.fiap.residex.model.Empresa;
import br.com.fiap.residex.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private Empresa empresa;

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaSemCaminhoesExibicaoDto create(EmpresaCadastroDto empresaCadastroDto) {

        BeanUtils.copyProperties(empresaCadastroDto, empresa);

        return new EmpresaSemCaminhoesExibicaoDto(empresaRepository.save(empresa));

    }

    public List<Empresa> findAll() {

        return empresaRepository.findAll();
    }

    public void delete(Long idEmpresa) {

        empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!"));

        empresaRepository.delete(empresa);
    }

    public EmpresaExibicaoDto update(Long idEmpresa, EmpresaUpdateDto empresaParam) {

        empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!"));

        if (empresaParam.razaoSocial() != null) {
            empresa.setRazaoSocial(empresaParam.razaoSocial());
        }

        Empresa empresaAtualizada = empresaRepository.save(empresa);
        return new EmpresaExibicaoDto(empresaAtualizada);
    }
}
