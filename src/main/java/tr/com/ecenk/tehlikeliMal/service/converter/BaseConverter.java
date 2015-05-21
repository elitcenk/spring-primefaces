package tr.com.ecenk.tehlikeliMal.service.converter;

import ch.qos.logback.classic.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ecenk.tehlikeliMal.domain.BaseModel;
import tr.com.ecenk.tehlikeliMal.service.BaseService;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by AKSTEST on 20/05/2015.
 */
@Service(value = "baseConverter")
public class BaseConverter implements Converter {

    private BaseService baseService;

    @Autowired
    public BaseConverter(BaseService baseService) {
        this.baseService = baseService;
    }


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        BaseModel baseModel = null;
        if(s.equalsIgnoreCase("Seçiniz"))
        {
            return baseModel;
        }
        if (s != null && s.trim().length() > 0) {
            String[] str = s.split("#");
            String className = str[0];
            String id = null;
            try {
                if(str.length > 1){
                    id = str[1];
                    baseModel = (BaseModel) baseService.find(Class.forName(className), Long.parseLong(id));
                }
                return baseModel;
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        try {
            ValueExpression vex = uiComponent.getValueExpression("value");
            return vex.getType(facesContext.getELContext()).newInstance();
        } catch (Exception e) {
            System.out.println("Converter is not able to get ValueExpression");
            //ignore..
        }
        return baseModel;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof String) {
            return (String) o;
        }
        if (o != null) {
            StringBuilder sb = new StringBuilder(o.getClass().getName());
            sb.append("#");
            sb.append(((BaseModel) o).getId());
            return sb.toString();
        }
        return null;
    }
}
