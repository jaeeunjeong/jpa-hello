package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속 상태
            Member member = new Member();
            member.setId(1L);
            member.setName("Jeong");

            // 영속 상태
            em.persist(member);

            // 값의 변경이 가능 update
            member = em.find(Member.class, 1L);
            member.setName("ABC"); // 값이 바뀐다.

            // 실제 db에 저장됨.
            tx.commit();

            // jpql
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(Member findMember : result) System.out.println(findMember.getName());

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
