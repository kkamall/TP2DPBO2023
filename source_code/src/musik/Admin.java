/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musik;

/**
 *
 * @author KazutoVV
 */
public class Admin {
    private int id_admin;
    private String username;
    private String password;
    
    public Admin(int id_admin, String username, String password)
    {
        this.id_admin = id_admin;
        this.username = username;
        this.password = password;
    }
    
    public void setIdAdmin(int id_admin)
    {
        this.id_admin = id_admin;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getIdAdmin()
    {
        return this.id_admin;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
}
