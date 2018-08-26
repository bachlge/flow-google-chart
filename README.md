# FlowGoogleMaps
Vaadin Flow - Integration of Google Charts Webcomponent

Could not believe how easy it is to use (well documented) WebComponets with Vaadin Flow.

In this small project I'm creating a class wrapping https://www.webcomponents.org/element/GoogleWebComponents/google-chart (GoogleChart.java) and using it XGoogleChartsView.java.

These chart types have been tested:
* Pie
* Pie3D
* Donut
* Line
* Area
* Stacked Area
* Column
* Bar
* Time Series
* Geo Chart

with data:
* from json file
* dynamically created


There are quite some things that need to be improved:
* there is a npe at "com.vaadin.flow.internal.JsonCodec.decodeWithoutTypeInfo" which I could not yet localize
* not yet figured out how setting a date dynamically can be achieved
* solved: not yet figured out how json data have to be formatted when used from a file in a geo-chart

any input on these topics is appreciated