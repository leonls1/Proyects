package CMS.appIntegradora.model.common;

//@JsonInclude

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class RepBase {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timeStamp = new Date();
    
    private Object response;

    public RepBase() {
    }

    public RepBase(Object response) {
        this.response = response;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
    
    
    
}
