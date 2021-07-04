package prasun.banking.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ACC_ROLE", joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "username"))
    private List<AccountModel> users = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<AccountModel> getUsers() {
        return users;
    }

    public void setUsers(List<AccountModel> users) {
        this.users = users;
    }

    public void addUser(AccountModel user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }

    public void removeUser(AccountModel user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }

}