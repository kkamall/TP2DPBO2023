/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musik;

/**
 *
 * @author KazutoVV
 */
public class AlbumMusik {
    private int id_album;
    private String nama_album;
    private String tahun_rilis;
    private String nama_musisi;
    private String path;
    
    public AlbumMusik(String nama_album, String tahun_rilis, String nama_musisi, String path)
    {
        this.id_album = id_album;
        this.nama_album = nama_album;
        this.tahun_rilis = tahun_rilis;
        this.nama_musisi = nama_musisi;
        this.path = path;
    }
    
    public void setIdAlbum(int id_album)
    {
        this.id_album = id_album;
    }
    
    public void setNamaFilm(String nama_album)
    {
        this.nama_album = nama_album;
    }
    
    public void setTahunRilis(String tahun_rilis)
    {
        this.tahun_rilis = tahun_rilis;
    }
    
    public void setNamaMusisi(String tahun_rilis)
    {
        this.nama_musisi = nama_musisi;
    }
    
    public void setPath(String tahun_rilis)
    {
        this.path = path;
    }
    
    public int getIdAlbum()
    {
        return this.id_album;
    }
    
    public String getNamaFilm()
    {
        return this.nama_album;
    }
    
    public String getTahunRilis()
    {
        return this.tahun_rilis;
    }
    
    public String getNamaMusisi()
    {
        return this.nama_musisi;
    }
    
    public String getPath()
    {
        return this.path;
    }
}
