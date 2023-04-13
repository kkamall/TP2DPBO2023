/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musik;

/**
 *
 * @author KazutoVV
 */
public class Musisi {
    private int id_musisi;
    private String nama_musisi;
    private String lagu_populer;
    private String path;
    
    public Musisi(int id_musisi, String nama_musisi, String lagu_populer, String path)
    {
        this.id_musisi = id_musisi;
        this.lagu_populer = lagu_populer;
        this.nama_musisi = nama_musisi;
        this.path = path;
    }
    
    public void setIdMusisi(int id_musisi)
    {
        this.id_musisi = id_musisi;
    }
    
    public void setNamaMusisi(String lagu_populer)
    {
        this.nama_musisi = nama_musisi;
    }
    
    public void setLaguPopuler(String lagu_populer)
    {
        this.lagu_populer = lagu_populer;
    }
    
    public void setPath(String lagu_populer)
    {
        this.path = path;
    }
    
    public int getIdMusisi()
    {
        return this.id_musisi;
    }
    
    public String getNamaMusisi()
    {
        return this.nama_musisi;
    }
    
    public String getLaguPopuler()
    {
        return this.lagu_populer;
    }
    
    public String getPath()
    {
        return this.path;
    }
}
