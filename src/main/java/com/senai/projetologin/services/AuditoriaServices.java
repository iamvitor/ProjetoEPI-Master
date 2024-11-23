package com.senai.projetologin.services;

import com.senai.projetologin.dtos.AuditoriaDto;
import com.senai.projetologin.models.UsuarioModels;
import com.senai.projetologin.models.MunicipioModels;
import com.senai.projetologin.models.ColaboradoresModels;
import com.senai.projetologin.models.CategoriaModels;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditoriaServices {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AuditoriaDto> obterRevisoes() {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Consulta as revisões de todas as entidades auditadas
        List<AuditoriaDto> auditorias = new ArrayList<>();

        auditorias.addAll(obterRevisoesPorEntidade(auditReader, UsuarioModels.class, "Usuario"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, MunicipioModels.class, "Municipio"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, ColaboradoresModels.class, "Contato"));
        auditorias.addAll(obterRevisoesPorEntidade(auditReader, CategoriaModels.class, "Estado"));

        return auditorias;
    }

    // Método para buscar as revisões de uma entidade específica
    private List<AuditoriaDto> obterRevisoesPorEntidade(AuditReader auditReader, Class<?> entidade, String nomeEntidade) {
        // Busca as revisões da entidade
        List<Object[]> results = auditReader.createQuery()
                .forRevisionsOfEntity(entidade, false, true)
                .addOrder(AuditEntity.revisionProperty("id").desc())
                .getResultList();

        // Converte as revisões para o DTO
        return results.stream().map(revision -> {
            Object entidadeObj = revision[0];
            DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) revision[1];
            RevisionType revisionType = (RevisionType) revision[2];

            // Converte o timestamp de revisão para LocalDateTime
            LocalDateTime dataHora = Instant.ofEpochMilli(revisionEntity.getTimestamp())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Converte o RevisionType para String
            String operacao;
            switch (revisionType) {
                case ADD:
                    operacao = "CREATE";
                    break;
                case MOD:
                    operacao = "UPDATE";
                    break;
                case DEL:
                    operacao = "DELETE";
                    break;
                default:
                    operacao = "UNKNOWN";
            }

            // Cria o DTO
            AuditoriaDto dto = new AuditoriaDto();
            if (entidadeObj instanceof UsuarioModels) {
                UsuarioModels usuario = (UsuarioModels) entidadeObj;
                dto.setId(usuario.getId());
                dto.setUsuario(usuario.getNome());
            } else if (entidadeObj instanceof MunicipioModels) {
                MunicipioModels municipio = (MunicipioModels) entidadeObj;
                dto.setId(municipio.getId());
                dto.setUsuario(municipio.getNome()); // Assume que a entidade MunicipioModels tem esse campo
            } else if (entidadeObj instanceof ColaboradoresModels) {
                ColaboradoresModels contato = (ColaboradoresModels) entidadeObj;
                dto.setId(contato.getId());
                dto.setUsuario(contato.getNome()); // Assume que a entidade ContatoModels tem esse campo
            } else if (entidadeObj instanceof CategoriaModels) {
                CategoriaModels estado = (CategoriaModels) entidadeObj;
                dto.setId(estado.getId());
                dto.setUsuario(estado.getNome()); // Assume que a entidade EstadoModels tem esse campo
            }

            dto.setEntidade(nomeEntidade);
            dto.setOperacao(operacao);
            dto.setDataHora(dataHora);

            return dto;
        }).collect(Collectors.toList());
    }
}
