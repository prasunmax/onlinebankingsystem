package prasun.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import prasun.banking.dao.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
