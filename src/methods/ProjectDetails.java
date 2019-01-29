package methods;

import java.util.ArrayList;

import databases.ProjectDetailsDao;

public class ProjectDetails {
static ArrayList<String> l;
public static ArrayList<String> get_project_details(String p_name)
{
	l=ProjectDetailsDao.get_from_project_table(p_name);
	return l;
}
}
