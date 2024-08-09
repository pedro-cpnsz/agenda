package modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class IconCellRenderer extends DefaultTableCellRenderer {
    private Icon icon;

    public IconCellRenderer(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void setValue(Object value) {
        setIcon(icon);
    }
}
