package RelojDigital;

import java.awt.Component;
import java.beans.*;

public class AlarmaPropertyEditor extends PropertyEditorSupport {
    
    private AlarmaEditorPanel editor = null;

    public AlarmaPropertyEditor() {
        this.editor = new AlarmaEditorPanel();
    }

    @Override
    public Component getCustomEditor() {
        return editor;
    }

    @Override
    public String[] getTags() {
        return null;
    }

    @Override
    public Object getValue() {
        if(super.getValue()==null){
            setValue(null);
        }
        Alarma ret = (Alarma) super.getValue();
        if (editor.txtHoras.getText().equals(""))
            ret.setHora(0);
        else
            ret.setHora(Integer.parseInt(editor.txtHoras.getText()));
        if (editor.txtMinutos.getText().equals(""))
            ret.setMinuto(0);
        else
            ret.setMinuto(Integer.parseInt(editor.txtMinutos.getText()));
        ret.setMensaje(editor.txtMsg.getText());
        ret.setActiva( editor.chkActiva.isSelected() );
        return ret;
    }

    @Override
    public void setValue(Object alarma) {
        if(alarma==null){
            alarma = new Alarma(0,0,"");
        }
        super.setValue(alarma);

    }

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public String getAsText(){
        return super.getAsText();
    }

    @Override
    public void setAsText(String text){
        throw new IllegalArgumentException("Alarma can not be set this way. Please use the editor.");
    }

    @Override
    public String getJavaInitializationString() {
        Alarma bean = (Alarma) getValue();
        StringBuffer ret = new StringBuffer();
        ret.append(Alarma.class.getName());
        ret.append(".createAlarma(\"");
        ret.append(bean.getHora());
        ret.append("\",\"");
        ret.append(bean.getMinuto());
        ret.append("\",\"");
        ret.append(bean.getMensaje());
        ret.append("\",\"");
        if (bean.isActiva())
            ret.append("alarma activa");
        else
            ret.append("alarma inactiva");

        return ret.toString();
    }

}
