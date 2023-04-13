/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musik;

/**
 *
 * @author KazutoVV
 */
public class Film {
    private String nama_film;
    private String deskripsi_film;
    
    public Film(String nama_film, String deskripsi_film)
    {
        this.nama_film = nama_film;
        this.deskripsi_film = deskripsi_film;
    }
    
    public void setNamaFilm(String nama_film)
    {
        this.nama_film = nama_film;
    }
    
    public void setDeskripsiFilm(String deskripsi_film)
    {
        this.deskripsi_film = deskripsi_film;
    }
    
    public String getNamaFilm()
    {
        return this.nama_film;
    }
    
    public String getDeskripsiFilm()
    {
        return this.deskripsi_film;
    }
}
