package org.vaadin.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.vaadin.data.TaskProvider;
import org.vaadin.enums.Fields;
import org.vaadin.enums.Priority;
import org.vaadin.work.Task;
import oshi.jna.platform.mac.SystemB;

import java.util.Arrays;
import java.util.List;

@Route("")
public class MainWorkTracker extends Div {

    VerticalLayout filterLayout;

    VerticalLayout taskListLayout;

    VerticalLayout contentLayout;

    VerticalLayout actionLayout;

    public MainWorkTracker() {
        VerticalLayout mainLayout = new VerticalLayout();
        VerticalLayout leftSideLayout = new VerticalLayout();
        VerticalLayout rightSideLayout = new VerticalLayout();

        filterLayout = createFilterLayout();
        taskListLayout = createTaskListLayout();
//        createContentLayout(new Task());
        mainLayout.add(filterLayout, taskListLayout);

        add(mainLayout);
    }

    public void createActionLayout() {
        actionLayout = new VerticalLayout();


    }

    public void createContentLayout(Task selectedTask) {
        contentLayout = new VerticalLayout();
        TextField reporter = new TextField("Reporter");
        TextField assignee = new TextField("Assignee");
//        DatePicker deadline = new DatePicker(Fields.DEADLINE.getValue());
        reporter.setValue(selectedTask.getReporter());
        assignee.setValue(selectedTask.getAssignee());
//        deadline.setValue();
        HorizontalLayout taskBarLayout = new HorizontalLayout();
        taskBarLayout.add(reporter, assignee);

        HorizontalLayout contentSubLayout = new HorizontalLayout();
        TextArea contentField = new TextArea();
        contentField.setWidthFull();
        contentField.setLabel("Description");
        contentField.setValue(selectedTask.getContent());
        contentSubLayout.add(contentField);

        contentLayout.add(taskBarLayout, contentSubLayout);
    }

    public VerticalLayout createTaskListLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        Grid<Task> grid = new Grid<Task>(Task.class);

        List<String> visibleColumns = Arrays.asList(
                "ID",
                "priority",
                "assignee",
                "reporter",
                "deadline",
                "content"
        );
        grid.getColumns().forEach(column -> {
            String key = column.getKey();
            if (!visibleColumns.contains(key)) {
                grid.removeColumn(column);
            }
        });

        grid.setColumnOrder(
                grid.getColumnByKey("ID"),
                grid.getColumnByKey("priority"),
                grid.getColumnByKey("assignee"),
                grid.getColumnByKey("reporter"),
                grid.getColumnByKey("deadline"),
                grid.getColumnByKey("content")
        );
//        grid.set
        grid.setItems(TaskProvider.createTaskMap().values());
        verticalLayout.add(grid);
        return verticalLayout;
    }

    public VerticalLayout createFilterLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        TextField reporter = new TextField("Reporter");
        TextField assignee = new TextField("Assignee");
        DatePicker deadline = new DatePicker(Fields.DEADLINE.getValue());

        Select<String> select = new Select<>();
        select.setLabel("Priority");
        select.setItems(Priority.LOW.getValue(), Priority.MEDIUM.getValue(), Priority.HIGH.getValue(), Priority.TRIVIAL.getValue());
        select.setPlaceholder("Select priority");

        Component[] components = {reporter, assignee, deadline, select};
        verticalLayout.add(components);
        return verticalLayout;
    }


}
