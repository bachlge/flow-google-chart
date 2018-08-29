package com.gork.FlowGoogleCharts.view;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.FlowGoogleCharts.components.googlechart.GoogleChart;
import com.gork.FlowGoogleCharts.components.googlechart.GoogleChart.ChartType;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@PageTitle("°°°Google Charts Experiments°°°")
@Route(value="x-google-charts", layout=MainView.class)
public class XGoogleChartsView extends Composite<Div> {

	private static final Logger LOGGER = LoggerFactory.getLogger(XGoogleChartsView.class);

	public XGoogleChartsView() {
		LOGGER.info("Constructor ...");

		H1 title = new H1("Google Charts");

		// Json Pie -- ok
		GoogleChart chart1a = new GoogleChart();
		chart1a.setType(ChartType.PIE);
		chart1a.setTitle("Pie Chart, data from Json-File");
		chart1a.setJsonDataFile("frontend/chart-data-pie.json");

		// Json Donut -- ok
		GoogleChart chart1b = new GoogleChart();
		chart1b.setType(ChartType.DONUT);
		chart1b.setOption("title", "Donut Chart, data from Json-File");
		chart1b.setOption("pieHole", 0.2);
		chart1b.setJsonDataFile("frontend/chart-data-pie.json");

		// Json Pie 3D -- ok
		GoogleChart chart1c = new GoogleChart();
		chart1c.setType(ChartType.PIE3D);
		chart1c.setOption("title", "3D Pie Chart, data from Json-File");
		chart1c.setOption("is3D", true);
		chart1c.setJsonDataFile("frontend/chart-data-pie.json");

		// Json Line -- ok
		GoogleChart chart2 = new GoogleChart();
		chart2.setType(ChartType.LINE);
		chart2.setTitle("Line Chart, data from Json-File");
		chart2.setOption("pointsVisible", true);
		chart2.setOption("curveType", "function");
		chart2.setJsonDataFile("frontend/chart-data-line.json");

		// Json Area -- ok
		GoogleChart chart3a = new GoogleChart();
		chart3a.setType(ChartType.AREA);
		chart3a.setTitle("Area Chart, data from Json-File");
		chart3a.setOption("pointsVisible", true);
		chart3a.setJsonDataFile("frontend/chart-data-area.json");

		// Json Stacked Area -- ok
		GoogleChart chart3b = new GoogleChart();
		chart3b.setType(ChartType.AREA);
		chart3b.setTitle("Area Chart Stacked, data from Json-File");
		chart3b.setOption("isStacked", true);
		chart3b.setJsonDataFile("frontend/chart-data-area.json");

		// Json Column -- ok
		GoogleChart chart4 = new GoogleChart();
		chart4.setType(ChartType.COLUMN);
		chart4.setTitle("Column Chart, data from Json-File");
		chart4.setJsonDataFile("frontend/chart-data-area.json");

		// Json Bar -- ok
		GoogleChart chart5 = new GoogleChart();
		chart5.setType(ChartType.BAR);
		chart5.setTitle("Bar Chart, data from Json-File");
		chart5.setJsonDataFile("frontend/chart-data-area.json");

		// Json Time Line -- ok
		GoogleChart chart6 = new GoogleChart();
		chart6.setType(ChartType.LINE);
		chart6.setTitle("Time Chart, data from Json-File, curved, points");
		chart6.setOption("subtitle", "curved, points");
		chart6.setOption("backgroundColor", "aliceblue");
		chart6.setOption("chartArea.backgroundColor", "white");
		chart6.setOption("legend.position", "bottom");
		chart6.setOption("pointsVisible", true);
		chart6.setOption("animation.duration", 2000.0);
		chart6.setOption("animation.startup", true);
		chart6.setOption("curveType", "function");
		chart6.setJsonDataFile("frontend/chart-data-time.json");

		// Dynamic Line -- ok
		GoogleChart chart7 = new GoogleChart();
		chart7.setType(ChartType.LINE);
		chart7.setTitle("Line Chart, dynamic data");
		chart7.addColumn("ColA", "string");
		chart7.addColumn("ColB", "number");
		chart7.addRow("DimA", 4.0);
		chart7.addRow("DimB", 3.5);
		chart7.addRow("DimC", 4.5);
		chart7.addRow("DimD", 5.0);

		// Dynamic Date Line -- TODO
		GoogleChart chart8 = new GoogleChart();
		chart8.setType(ChartType.LINE);
		chart8.setTitle("Time Chart, dynamic data");
		chart8.addColumn("ColA", "date");
		chart8.addColumn("ColB", "number");
		chart8.addRow(new Date(2013,01,01), 4.0);
		chart8.addRow(new Date(2016,01,01), 3.5);
		chart8.addRow(new Date(2017,01,01), 4.5);
		chart8.addRow(new Date(2020,01,01), 5.0);

		// Dynamic Date Line from Object -- TODO
		GoogleChart chart8b = new GoogleChart();
		chart8b.setType(ChartType.LINE);
		chart8b.setTitle("Time Chart, dynamic data from object");
		chart8b.addColumn("ColA", "date");
		chart8b.addColumn("ColB", "number");

		// Json Geo -- ok
		GoogleChart chart9a = new GoogleChart();
		chart9a.setType(ChartType.GEO);
		chart9a.setTitle("Geo Chart, data from Json-File");
		chart9a.setOption("region", "002"); // Africa
		chart9a.setOption("region", "005"); // South America
		chart9a.setOption("region", "021"); // Northern America
		chart9a.setOption("region", "053"); // Australia and New Zealand
		chart9a.setOption("region", "142"); // Asia
		chart9a.setOption("region", "150"); // Europe
		chart9a.setOption("region", "151"); // Eastern Europe BG, BY, CZ, HU, MD, PL, RO, RU, SU, SK, UA
		chart9a.setOption("region", "154"); // Northern Europe GG, JE, AX, DK, EE, FI, FO, GB, IE, IM, IS, LT, LV, NO, SE, SJ
		chart9a.setOption("region", "155"); // Western Europe AT, BE, CH, DE, DD, FR, FX, LI, LU, MC, NL
		chart9a.setOption("region", "039"); // Southern Europe AD, AL, BA, ES, GI, GR, HR, IT, ME, MK, MT, CS, RS, PT, SI, SM, VA, YU
		chart9a.setOption("region", "150"); // Europe
		chart9a.setJsonDataFile("frontend/chart-data-geo.json");
		LOGGER.info("Geo-Data (json)=" + chart9a.getElement().getProperty("data"));

		// Dynamic Geo -- ok
		GoogleChart chart9b = new GoogleChart();
		chart9b.setType(ChartType.GEO);
		chart9b.setTitle("Geo Chart, dynamic data");
		chart9b.setOption("region", "150"); // Europe
		chart9b.addData("Country", "Greenity-Factor");
		chart9b.addData("AT", 600.0);
		chart9b.addData("IE", 550.0);
		chart9b.addData("Finland", 500.0);
		chart9b.addData("EE", 450.0);
		chart9b.addData("France", 400.0);
		chart9b.addData("Norway", 350.0);
		chart9b.addData("Portugal", 300.0);
		chart9b.addData("Iceland", 250.0);
		chart9b.addData("Greece", 200.0);
		chart9b.addData("RO", 150.0);
		chart9b.addData("Poland", 100.0);
		chart9b.addData("LT", 50.0);
		LOGGER.info("Geo-Data (runtime)=" + chart9b.getElement().getProperty("data"));

		Paragraph copyright = new Paragraph();
		copyright.setText("(c) Gork 2018");
		copyright.addClassName("copyright");

		getContent().add(
				title,
				new HorizontalLayout(chart1a, chart1b, chart1c),
				new Hr(),
				new HorizontalLayout(chart2, chart3a, chart3b),
				new Hr(),
				new HorizontalLayout(chart4, chart5, chart6),
				new Hr(),
				new HorizontalLayout(chart7, chart8, chart8b),
				new Hr(),
				new HorizontalLayout(chart9a, chart9b),
				copyright
			);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

}
