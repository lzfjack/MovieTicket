package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="fid", nullable=false)
	@Id
	//@GeneratedValue
	private int fid;
	
	@Column(name="fname", nullable=false)
	private String fname;
	
	@Column(name="introduction")
	private String introduction;
	
	@Column(name="length", nullable=false)
	private float length;
	
	@Column(name="score", nullable=false)
	private float score;//may should be an int???
	
	@Column(name="area", nullable=false)
	private String area;
	
	@Column(name="premiereDate", nullable=false)
	private int premiereDate;
	
	@Column(name="sale", nullable=false)
	private int sale;
	
	/*@Column(name="posterURL", nullable=false)
	private String posterURL;*/
	
	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="film_actor",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="aid", referencedColumnName="aid")
				})
	private List<Actor> a = new ArrayList<Actor>();
	
	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="film_filmversion",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="fvid", referencedColumnName="fvid")
				})
	private List<FilmVersion> fv = new ArrayList<FilmVersion>();
	
	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="film_filmtype",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="ftid", referencedColumnName="ftid")
				})
	private List<FilmType> ft = new ArrayList<FilmType>();
	
	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="film_director",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="did", referencedColumnName="did")
				})
	private List<Director> d = new ArrayList<Director>();
	
	@ManyToMany(cascade={CascadeType.ALL,CascadeType.ALL,CascadeType.MERGE})
	@JoinTable(name="film_language",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="lid", referencedColumnName="lid")
				})
	private List<Language> l = new ArrayList<Language>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="film")
	private List<PlayList> playLists =  new ArrayList<PlayList>();
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="film_cinema",
				joinColumns={
						@JoinColumn(name="fid", referencedColumnName="fid")
				},
				inverseJoinColumns={
						@JoinColumn(name="cid", referencedColumnName="cid")
				})
	private List<Cinema> cinemas = new ArrayList<Cinema>();
	
	
	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public List<PlayList> getPlayLists() {
		return playLists;
	}

	public void setPlayLists(List<PlayList> playLists) {
		this.playLists = playLists;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	public List<Actor> getA() {
		return a;
	}

	public void setA(List<Actor> a) {
		this.a = a;
	}

	public List<FilmVersion> getFv() {
		return fv;
	}

	public void setFv(List<FilmVersion> fv) {
		this.fv = fv;
	}

	public List<FilmType> getFt() {
		return ft;
	}

	public void setFt(List<FilmType> ft) {
		this.ft = ft;
	}

	public List<Director> getD() {
		return d;
	}

	public void setD(List<Director> d) {
		this.d = d;
	}

	public List<Language> getL() {
		return l;
	}

	public void setL(List<Language> l) {
		this.l = l;
	}

	public Film() {}
	
	public Film(int fid, String fname, String introduction, float length, float score, String area,
			int premiereDate, String posterURL) {
		this.fid = fid;
		this.fname = fname;
		this.introduction = introduction;
		this.length = length;
		this.score = score;
		this.area = area;
		this.premiereDate = premiereDate;
		//this.posterURL = posterURL;
	}



	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(int premiereDate) {
		this.premiereDate = premiereDate;
	}

	/*public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}*/
	
	@Override                                                           
	public String toString() {
		return "Film [fid=" + fid + ", fname=" + fname 
				+ ", introduction=" + introduction 
				+ ", length=" + length 
				+ ", scroe=" + score
				+ ", area=" + area
				//+ ", posterURL=" +posterURL
				+ ", premiereDate=" + premiereDate
				+ "]";
	}
}
