package com.transaction.first;

import java.io.IOException;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@Autowired
	DateRepository repo;
	@GetMapping("/")
	public String selectdate() {
		return "selectDate";
	}

	@PostMapping("/transactions")
	public String getAllTransactions(@ModelAttribute Dateclass date,Model model) {
		List<List<String>> total=new ArrayList<>();
		List<Transaction> oc=repo.findByDa(date.getDate());
		Set<String>check=new HashSet<>();
		List<Transaction> suc=repo.findByDate(date.getDate(),"SUCCESS");
		List<Transaction> fai=repo.findByDate(date.getDate(),"FAILURE");
		List<Transaction> pen=repo.findByDate(date.getDate(),"PENDING");
		System.out.println(oc);
		Collections.sort(oc, (o1, o2) -> o1.org_code.compareTo(o2.org_code));
//		Comparator<Transaction> occ=new Comparator<Transaction>() {
//			@Override
//			public int compare(Transaction o1, Transaction o2) {
//				return o1.org_code.compareTo(o2.org_code);
//			}
//		};
//		Collections.sort(oc,occ);
		System.out.println(oc);
		for(int i=0;i<oc.size();i++){
			Transaction obj=oc.get(i);
			String a,b,c;
			a=String.valueOf(repo.findCount(date.getDate(), "SUCCESS",obj.org_code));
			b=String.valueOf(repo.findCount(date.getDate(), "FAILURE",obj.org_code));
			c=String.valueOf(repo.findCount(date.getDate(), "PENDING",obj.org_code));
			if(total.isEmpty()){
				total.add(new ArrayList<String>(Arrays.asList(String.valueOf(obj.org_code),a,b,c))); }
			if(!obj.org_code.equals(total.get(total.size()-1).get(0))){
				total.add(new ArrayList<String>(Arrays.asList(String.valueOf(obj.org_code),a,b,c))); }
			}
//		}
//		for(int i=0;i<oc.size();i++) {
//			Transaction obj=oc.get(i);
//			String a,b,c;
//				a=String.valueOf(repo.findCount(date.getDate(), "SUCCESS",obj.org_code));
//				b=String.valueOf(repo.findCount(date.getDate(), "FAILURE",obj.org_code));
//				c=String.valueOf(repo.findCount(date.getDate(), "PENDING",obj.org_code));
//	if(a.equals("0")&&b.equals("0")&&c.equals("0")) continue;
//	if(total.isEmpty()){
//		total.add(new ArrayList<String>(Arrays.asList(String.valueOf(obj.org_code),a,b,c)));
//			check.add(String.valueOf(obj.org_code));
//	}
//	if(!check.contains(obj.org_code)){
//		total.add(new ArrayList<String>(Arrays.asList(String.valueOf(obj.org_code),a,b,c)));
//		check.add(obj.org_code);
//	}
//		}
		System.out.println(total);
		model.addAttribute("success",suc);
		model.addAttribute("failure",fai);
		model.addAttribute("pending",pen);
		model.addAttribute("total",total);
		return "result";
	}
}




