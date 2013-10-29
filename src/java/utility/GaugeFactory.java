/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.softwarefx.chartfx.gauge.*;
import java.awt.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Ayemi
 */
public class GaugeFactory implements Serializable{

    public StreamedContent chart;

    public GaugeFactory(int min, int med, int max, int value,String title) {
        RadialGauge gauge = new RadialGauge();
        RadialGauge.setLicenseString("t4z8mP/DAACrgUnjG9fjQDkTAAAeAAAAAQAAAAdUUkNGSjcwC1NGWERPV05MT0FEZ05TPTE7TWFwcz1ULDMwMTAsMzAsNDkyMSxUUkNGSjcwLDE7U3RhdGlzdGljYWw9VCwzMDEwLDMwLDQ5MjEsVFJDRko3MCwxO0dhdWdlcz1ULDMwMTAsMzAsNDkyMSxUUkNGSjcwLDEBAAAAAVQAAAAAABpCdWlsdCB1c2luZyBDaGFydCBGWCBUcmlhbA==*&mq+FVvke8YRbsbvmZDnOJZAYhcuf4L9KkTkf4RwBRZt5ma6h34vR++dsTPsuQl0+/30jjCc9dVErXM3I6pyVydPuLkkF9Mxq65BxrGSt+vdrR/yE7FPZYJZYrvSVwDxLTQdDy5l/rDLjU0ePVyLijzwC3t3h6CEKDjJEvZmaVDE=");
// chartfx70
        //gauge.setBackColor = java.awt.Color.white;
        gauge.getBorder().setColor(new java.awt.Color(230, 232, 250));  // Color Silver
        gauge.getBorder().setGlare(true);
        gauge.getBorder().setInsideColor(java.awt.Color.LIGHT_GRAY);
        gauge.getBorder().setStyle(RadialBorderStyle.getSemiCircularBorder07());
        gauge.getBorder().setGlare(false);

        //Setting the MainScale
        gauge.getMainScale().setMax(max);

        //Setting first Section
        Section section1 = new Section();
        section1.setMin(min);
        section1.setMax(med);
        section1.getBar().setColor(Color.yellow);
        section1.getTickmarks().setColor(Color.white);
        gauge.getMainScale().getSections().add(section1);

        //Setting second Section
        section1 = new Section();
        section1.setMin(med);
        section1.setMax(max);
        section1.getBar().setColor(Color.red);
        section1.getTickmarks().setColor(Color.white);
        gauge.getMainScale().getSections().add(section1);

        gauge.getMainScale().getBar().setVisible(false);

        gauge.getMainScale().getCap().setStyle(RadialCapStyle.getRotatingCap02());
        gauge.getMainScale().getCap().setColor(Color.darkGray);

        Needle needle1 = (Needle) gauge.getMainIndicator();
        needle1.setStyle(NeedleStyle.getNeedle10());
        needle1.setUseRangeColor(RangeType.SECTION);
        needle1.setValue(value);

        gauge.getMainScale().getTickmarks().getMajor().setColor(Color.darkGray);
        gauge.getMainScale().getTickmarks().getMajor().getLabel().setFont(new GaugeFont("Tahoma", GaugeFontSize.SMALLER, java.awt.Font.BOLD));
        gauge.getMainScale().getTickmarks().getMajor().getLabel().setColor(Color.white);
        gauge.getMainScale().getTickmarks().getMajor().setStep(5);
        gauge.getMainScale().getTickmarks().getMajor().setStyle(TickmarkStyle.getTickmark01_2());
        gauge.getMainScale().getTickmarks().getMedium().setColor(new java.awt.Color(230, 232, 250));  // Color Silver
        gauge.getMainScale().getTickmarks().getMinor().setColor(Color.gray);

        //Setting the titles:

        Title title1 = new Title();
        title1.setText(title);
        title1.setColor(new java.awt.Color(211, 211, 211));  // Color LightGray
        title1.setFont(new GaugeFont("Tahoma", GaugeFontSize.SMALLER, java.awt.Font.BOLD));
        title1.getLayout().setTarget(LayoutTarget.ANCHOR_POINT);
        title1.getLayout().getAnchorPoint().setLocation(0, 0.225);
        gauge.getTitles().add(title1);

        gauge.setWidth(220);
        gauge.setHeight(250);
        gauge.setToolTipEnabled(false);
        try {
            //gauge.renderToStream();
            gauge.exportGauge(ImageFormat.getPng(), title + ".png");
          
            chart = new DefaultStreamedContent(new FileInputStream(title + ".png"), "image/png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GaugeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GaugeFactory.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public StreamedContent getChart() {
        return chart;
    }
}
