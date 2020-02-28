package edu.northeastern.cs5200.daos;

import java.util.List;

import edu.northeastern.cs5200.models.Widget;

public interface WidgetDao {
	public void createWidgetForPage(int pageId, Widget widget);
	public List<Widget> findAllWidgets();
	public Widget findWidgetById(int widgetId);
	public List<Widget> findWidgetsForPage(int pageId);
	public int updateWidget(int widgetId, Widget widget);
	public int deleteWidget(int widgetId);

}
