package pack01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import DB.OracleDB;
import model.Apple;

@Controller
public class Home {

	OracleDB db = new OracleDB();
	

	@RequestMapping("/t1")
	public String t1(Model model) {

		ArrayList<Apple> appleArray = new ArrayList<Apple>();
		ResultSet rs = db.executeQuery("SELECT * FROM TABEX");

		System.out.println(rs);

		try {
			while (rs.next()) {
				appleArray.add(new Apple(rs.getString("name"), rs.getInt("age")));
			}

		} catch (SQLException e) {
			e.toString();
		}

		System.out.println(appleArray);

		model.addAttribute("array", appleArray);

		return "OracleTestView";
	}

	public void close() {
		db.close();
	}
}
