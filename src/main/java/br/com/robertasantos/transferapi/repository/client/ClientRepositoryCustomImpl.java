package br.com.robertasantos.transferapi.repository.client;

import br.com.robertasantos.transferapi.domain.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientRepositoryCustomImpl implements ClientRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client findById(String accountNumber) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);

        Root<Client> root = cq.from(Client.class);
        CriteriaQuery<Client> query = cq.select(root);

        Predicate predicado = cb.equal(root.get("accountNumber"), accountNumber);

        Predicate[] predicates = { predicado };

        query.where(predicates);

        TypedQuery<Client> tq = entityManager.createQuery(query);

        try {
            return tq.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
