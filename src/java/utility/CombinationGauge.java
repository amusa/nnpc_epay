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
public class CombinationGauge implements Serializable{

    public StreamedContent chart;

    public CombinationGauge(String value) {

        RadialGauge gauge = new RadialGauge();
        RadialGauge.setLicenseString("t4z8mP/DAACrgUnjG9fjQDkTAAAeAAAAAQAAAAdUUkNGSjcwC1NGWERPV05MT0FEZ05TPTE7TWFwcz1ULDMwMTAsMzAsNDkyMSxUUkNGSjcwLDE7U3RhdGlzdGljYWw9VCwzMDEwLDMwLDQ5MjEsVFJDRko3MCwxO0dhdWdlcz1ULDMwMTAsMzAsNDkyMSxUUkNGSjcwLDEBAAAAAVQAAAAAABpCdWlsdCB1c2luZyBDaGFydCBGWCBUcmlhbA==*&mq+FVvke8YRbsbvmZDnOJZAYhcuf4L9KkTkf4RwBRZt5ma6h34vR++dsTPsuQl0+/30jjCc9dVErXM3I6pyVydPuLkkF9Mxq65BxrGSt+vdrR/yE7FPZYJZYrvSVwDxLTQdDy5l/rDLjU0ePVyLijzwC3t3h6CEKDjJEvZmaVDE=");
        gauge.getBorder().setColor(java.awt.Color.gray);
        gauge.getBorder().setInsideColor(java.awt.Color.black);
        gauge.getBorder().setStyle(RadialBorderStyle.getCircularBorder06());

        InnerDigitalPanel innerDigitalPanel1 = new InnerDigitalPanel();
        innerDigitalPanel1.getSize().setSize(0.7, 0.20);
        innerDigitalPanel1.getDigitalPanel().setValue(value); //value
        innerDigitalPanel1.getDigitalPanel().getAppearance().setStyle(DigitalCharacterStyle.getLed01());
        innerDigitalPanel1.getDigitalPanel().getAppearance().setColor(new java.awt.Color(135, 206, 250));  // Color LightSkyBlue
        innerDigitalPanel1.getDigitalPanel().getAppearance().setOffDigitTransparency((short) 0);
        innerDigitalPanel1.getDigitalPanel().getBorder().setStyle(LinearBorderStyle.getLinearBorder06());
        innerDigitalPanel1.getDigitalPanel().getBorder().setColor(new java.awt.Color(105, 105, 105));  // Color DimGray
        innerDigitalPanel1.getDigitalPanel().getBorder().setInsideColor(new java.awt.Color(64, 64, 64));
        innerDigitalPanel1.getLayout().setTarget(LayoutTarget.ANCHOR_POINT);
        innerDigitalPanel1.getLayout().getAnchorPoint().setLocation(0.025, -0.45);

        innerDigitalPanel1.getDigitalPanel().setHeight(20);
        innerDigitalPanel1.getDigitalPanel().setWidth(300);
        gauge.getInnerGauges().add(innerDigitalPanel1);

        //Setting the MainScale
        gauge.getMainScale().getBar().setVisible(false);
        gauge.getMainScale().setRadius(0.7F);
        gauge.getMainScale().setStartAngle(204F);
        gauge.getMainScale().setMax(10); //max
        gauge.getMainScale().setSweepAngle(-228F);

        gauge.getMainScale().getCap().setSize(0.2F);
        gauge.getMainScale().getCap().setColor(new java.awt.Color(230, 232, 250));  // Color Silver

        Needle needle1 = (Needle) gauge.getMainIndicator();
        needle1.setSize(0.9F);
        needle1.setValue(value); //value
        needle1.setStyle(NeedleStyle.getNeedle05());
        needle1.setColor(new java.awt.Color(70, 130, 180));  // Color SteelBlue

        gauge.getMainScale().getTickmarks().getMajor().setColor(new Color(230, 232, 250));  // Color Silver
        gauge.getMainScale().getTickmarks().getMajor().getLabel().setFont(new GaugeFont("Tahoma", GaugeFontSize.SMALLER, java.awt.Font.BOLD));
        gauge.getMainScale().getTickmarks().getMajor().getLabel().setColor(new java.awt.Color(230, 232, 250));  // Color Silver
        gauge.getMainScale().getTickmarks().getMajor().setSize(2.5F);
        gauge.getMainScale().getTickmarks().getMajor().setStep(1);
        gauge.getMainScale().getTickmarks().getMajor().setStyle(TickmarkStyle.getTickmark01_2());

        gauge.getMainScale().getTickmarks().getMedium().setColor(new java.awt.Color(105, 105, 105));  // Color DimGray

        gauge.getMainScale().getTickmarks().getMinor().setColor(new java.awt.Color(105, 105, 105));  // Color DimGray
        gauge.getMainScale().getTickmarks().getMinor().setSize(1F);
        gauge.getMainScale().getTickmarks().getMinor().setStyle(TickmarkStyle.getTickmark02_3());

        //Setting the titles:
        Title title1 = new Title();
        title1.setText("Appraisal");
        title1.setColor(new java.awt.Color(220, 220, 220));  // Color Gainsboro
        title1.getLayout().setTarget(LayoutTarget.ANCHOR_POINT);
        title1.getLayout().getAnchorPoint().setLocation(0.05, -0.625);
        title1.setFont(new GaugeFont("Tahoma", GaugeFontSize.SMALLER, java.awt.Font.PLAIN));
        gauge.getTitles().add(title1);

        title1 = new Title();
        title1.setText("MADE IN THE US");
        title1.setColor(new java.awt.Color(105, 105, 105));  // Color DimGray
        title1.getLayout().setTarget(LayoutTarget.ANCHOR_POINT);
        title1.getLayout().getAnchorPoint().setLocation(0, -0.75);
        title1.setFont(new GaugeFont("Tahoma", GaugeFontSize.SMALLEST, java.awt.Font.PLAIN));
        gauge.getTitles().add(title1);

        gauge.setWidth(220);
        gauge.setHeight(250);
        gauge.setToolTipEnabled(false);

        try {
            //gauge.renderToStream();
            gauge.exportGauge(ImageFormat.getPng(), "appraisal.png");
        } catch (IOException ex) {
            Logger.getLogger(CombinationGauge.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            chart = new DefaultStreamedContent(new FileInputStream("appraisal.png"), "image/png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CombinationGauge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StreamedContent getChart() {
        return chart;
    }
}
