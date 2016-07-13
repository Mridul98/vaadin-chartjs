package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

/**
 * The radial linear scale is used specifically for the radar and polar are chart types. 
 * It overlays the chart area, rather than being positioned on one of the edges.
 *
 * @author michael@team-conductor.com
 */
public class RadialLinearScale extends BaseScale<RadialLinearScale> {
    
    private Boolean lineArc;
    private Boolean reverse;
    private RadialLinearTicks<RadialLinearScale> radialLinearTicks;
    private RadialAngleLine<RadialLinearScale> angleLines;
    private RadialPointLabel<RadialLinearScale> pointLabels;

    public RadialLinearScale() {
        type(null);
    }
    
    /**
     * If true, circular arcs are used else straight lines are used. The former is used by the polar area chart and the latter by the radar chart
     */
    public RadialLinearScale lineArc(boolean lineArc) {
        this.lineArc = lineArc;
        return this;
    }
    
    /**
     * 
     */
    public RadialLinearScale reverse(boolean reverse) {
        this.reverse = reverse;
        return this;
    }
    
    /**
     * Used to configure angled lines that radiate from the center of the chart to the point labels. Note that these options only apply if lineArc is false.
     */
    public RadialAngleLine<RadialLinearScale> angleLines() {
        if (this.angleLines == null) {
            this.angleLines = new RadialAngleLine<>(getThis());
        }
        return this.angleLines;
    }
    
    /**
     * Used to configure angled lines that radiate from the center of the chart to the point labels. Note that these options only apply if lineArc is false.
     */
    public RadialPointLabel<RadialLinearScale> pointLabels() {
        if (this.pointLabels == null) {
            this.pointLabels = new RadialPointLabel<>(getThis());
        }
        return this.pointLabels;
    }

    /**
     * It defines options for the tick marks that are generated by the axis.
     */
    @Override
    public RadialLinearTicks<RadialLinearScale> ticks() {
        if (this.radialLinearTicks == null) {
            this.radialLinearTicks = new RadialLinearTicks<>(getThis());
        }
        return this.radialLinearTicks;
    }

    @Override
    public RadialLinearScale getThis() {
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "reverse", reverse);
        JUtils.putNotNull(map, "lineArc", lineArc);
        JUtils.putNotNull(map, "angleLines", angleLines);
        JUtils.putNotNull(map, "pointLabels", pointLabels);
        JUtils.putNotNull(map, "ticks", radialLinearTicks);
        return map;
    }
}
