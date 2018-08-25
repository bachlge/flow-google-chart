package com.gork.FlowGoogleCharts.components.googlechart;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.impl.JreJsonFactory;


@SuppressWarnings("serial")
@Tag("google-chart")
@HtmlImport("bower_components/google-chart/google-chart.html")
public class GoogleChart extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleChart.class);

	private transient JreJsonFactory jsonFactory = new JreJsonFactory();

	private JsonObject opts = jsonFactory.createObject();
	private JsonArray cols = jsonFactory.createArray();
	private JsonArray rows = jsonFactory.createArray();

	@JsonSerialize(as = Date.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	public enum ChartType {
		PIE("pie"),
		PIE3D("pie"), // 3D is created via the is3D-option
		DONUT("pie"), // Donut is created via the pieHole-option
		BAR("bar"),
		COLUMN("column"),
		AREA("area"),
		LINE("line"),
		TIMELINE("timeline"),
		GEO("geo");

		private String type;
		ChartType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}


	public GoogleChart() {
		LOGGER.info("Constructor ...");

		getElement().getStyle().set("border-style", "solid");
		getElement().getStyle().set("border-width", "3px");
		getElement().getStyle().set("border-color", "red");

		getElement().getStyle().set("height", "360px");
		getElement().getStyle().set("width", "360px");

		// needed for geo-chart --> application using this should set the property!
		//getElement().setProperty("mapsApiKey", "AIzaSyC0B_DIHuzF_D21l9HhlRW4ZhjIFvzk5fc");
	}

	public void setType(ChartType type) {
//		getElement().setProperty("type", type.getType());
		setProperty("type", type.getType());
	}

	public void setTitle(String title) {
//		opts.put("title", title);
		setOption("title", title);
		setProperty("options", opts);
	}

	public void setOption(String category, String value) {
		opts.put(category, value);
		setProperty("options", opts);
	}

	public void setOption(String category, Double value) {
		opts.put(category, value);
		setProperty("options", opts);
	}

	public void setOption(String category, Boolean value) {
		opts.put(category, value);
		setProperty("options", opts);
	}

	// cols: (!Array|undefined)
	public void addColumn(String label, String type) {
		JsonObject col = jsonFactory.createObject();
		col.put("label", label);
		col.put("type", type);
		cols.set(cols.length(), col);
//		getElement().setPropertyJson("cols", cols);
		setProperty("cols", cols);
	}

	// rows: (!Array.<!Array>|undefined)
	public void addRow(String dimension, Double value) {
		JsonArray row = jsonFactory.createArray();
		row.set(0, dimension);
		row.set(1, value);
		rows.set(rows.length(), row);
//		getElement().setPropertyJson("rows", rows);
		setProperty("rows", rows);
	}

	public void addRow(Date idate, Double value) {
		JsonArray row = jsonFactory.createArray();
		date = idate;
		row.set(0, date.getDate());
		row.set(1, value);
		rows.set(rows.length(), row);
//		getElement().setPropertyJson("rows", rows);
		setProperty("rows", rows);
	}

	public void addData(String dimension, String value) {
		JsonArray row = jsonFactory.createArray();
		row.set(0, dimension);
		row.set(1, value);
		rows.set(rows.length(), row);
		setProperty("data", rows);
	}

	public void addData(String dimension, Double value) {
		addRow(dimension, value);
		setProperty("data", rows);
	}

	// in case the property value is a String
	protected void setProperty(String property, String data) {
        getElement().setProperty(property, data);
    }

	// in case the property value is a JsonObject
	protected void setProperty(String property, JsonObject data) {
        getElement().setPropertyJson(property, data);
    }

	// in case the property value is a JsonArray
	protected void setProperty(String property, JsonArray data) {
        getElement().setPropertyJson(property, data);
    }

	public void setJsonDataFile(String jsonFile) {
		getElement().setProperty("data", jsonFile);
	}

	public void redraw() {
		getElement().callFunction("redraw");
	}

	@Synchronize("google-chart-ready")
	public Object getReady() {
		LOGGER.info("onReady ...");
		return null;
	}

	@Synchronize("google-chart-select")
	public Object getSelect() {
		LOGGER.info("onSelect ...");
		return null;
	}

	@Synchronize("selection-changed")
	public Object getSelectionChanged() {
		LOGGER.info("onSelectionChanged ...");
		return null;
	}

}
