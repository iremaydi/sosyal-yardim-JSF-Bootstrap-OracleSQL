package Controller;

import Entity.Guvence;
import dao.GuvenceDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "guvenceBean")
@ViewScoped
public class GuvenceBean implements Serializable {

    private Guvence entity;
    private GuvenceDAO dao;
    private List<Guvence> list;
    private List<SelectItem> guvencelist;

    @PostConstruct
    public void init() {
    }

    public GuvenceBean() {
    }

    public Guvence getEntity() {
        return entity;
    }

    public void setEntity(Guvence entity) {
        this.entity = entity;
    }

    public GuvenceDAO getDao() {
        return dao;
    }

    public void setDao(GuvenceDAO dao) {
        this.dao = dao;
    }

    public List<Guvence> getList() {
        return list;
    }

    public void setList(List<Guvence> list) {
        this.list = list;
    }

    public List<SelectItem> getGuvencelist() {
        return guvencelist;
    }

    public void setGuvencelist(List<SelectItem> guvencelist) {
        this.guvencelist = guvencelist;
    }

}
