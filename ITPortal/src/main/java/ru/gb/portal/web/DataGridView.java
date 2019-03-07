package ru.gb.portal.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import ru.gb.portal.domain.entity.Advertisement;
import ru.gb.portal.domain.service.PortalService;

@Named
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DataGridView implements Serializable {
	
	private static final long serialVersionUID = 2933921029007009121L;

	private List<Advertisement> ads;
	
	private Advertisement selectedAd;
     
    @Autowired
    private PortalService service;
     
    @PostConstruct
    public void init() {
        ads = service.getAll();
    }
 
    public List<Advertisement> getAds() {
        return ads;
    }
 
    public void setService(PortalService service) {
        this.service = service;
    }

	public Advertisement getSelectedAd() {
		return selectedAd;
	}

	public void setSelectedAd(Advertisement selectedAd) {
		this.selectedAd = selectedAd;
	}
	
	public void addAdv(Advertisement adv) {
		service.save(adv);
	}

}
