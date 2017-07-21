package com.action;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.management.Query;
import javax.naming.LinkLoopException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.hibernate.metamodel.domain.AbstractAttributeContainer;
import org.hibernate.sql.ANSICaseFragment;
import org.springframework.web.filter.OncePerRequestFilter;

import com.entity.TQuestion;
import com.entity.TUserExam;
import com.mysql.fabric.Response;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


import java.awt.image.VolatileImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;

 
  

public class ExamAction implements Action{
	private SessionFactory factory;
	private String userId; 
	private String ks_cj;
	private String Exam_id,Paper_id;
	private String kanswer,zanswer;
	private String Exam_n_s_e;
	private HttpServletResponse response;
	private DecimalFormat    df   = new DecimalFormat("######0.00");   
	private String searchtxt;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * used in index.jsp,skip to dashboard or other(error)
	 * @return
	 */
	public String doSearch()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		HttpServletRequest request=ServletActionContext.getRequest();
		// TODO Auto-generated method stub
		Transaction tx = null;
		userId = "30";
		Session session = factory.openSession();
		try
		{
			String hql_list = "from TUserExam where userId = '" + userId + "'";
			org.hibernate.Query query = session.createQuery(hql_list);
			@SuppressWarnings("unchecked")
			List<TUserExam> list = query.list();
			System.out.println(list.size());
			for(int i=0;i<list.size();++i)
				System.out.println(list.get(i).getTExam().getName());
			ActionContext.getContext().getValueStack().set("list", list);
			ActionContext.getContext().getValueStack().set("userId", userId);
			
			String hql = "from TUserExam";
			String hql_cou = "select count(*) from TUserExam u where u.count>0 and userid = " + userId;
			String hql_pass = "select count(*) from TUserExam u where u.count>0 and zscore+kscore >= 60 and userid = " + userId;
			String hql_exam_be = "select count(*) from TUserExam where takedate > date_format(now(),'%Y-%m-%d %H-%i-%s')";
			query = session.createQuery(hql_cou);
			Object count,pass,ratio = null,begin;
			count = pass = begin = null;
			if(!query.list().isEmpty()) count = query.list().get(0); 
			query = session.createQuery(hql_pass);
			if(!query.list().isEmpty()) pass = query.list().get(0); 
			query = session.createQuery(hql_exam_be);
			if(!query.list().isEmpty()) begin = query.list().get(0); 
			Number num1,num2;
			num1 = (Number)count;
			num2 = (Number)pass;
			if(!num1.equals(0)) ratio = (df.format((num2.doubleValue()/num1.doubleValue())*100)) + "%";
			else ratio = "您还没有参加任何考试";
			ActionContext.getContext().getValueStack().set("count", count);
			ActionContext.getContext().getValueStack().set("pass", pass);
			ActionContext.getContext().getValueStack().set("exam_be", begin);
			ActionContext.getContext().getValueStack().set("ratio", ratio);
			session.close();
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	/**
	 * used in dashboard,find some element of user
	 * @return 
	 */
	public String doSearch_exam()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		Transaction tx = null;
		Session session = factory.openSession();
		try
		{
			boolean f1,f2,f3,f4;
			f1 = f2 = f3 = f4 = false;
			System.out.println(Exam_n_s_e);
			String[] value = Exam_n_s_e.split("_");
			for(int i = 0;i <value.length;i++) System.out.println(value[i]);
			if(value[0].equals("~")) f1 = true;
			value[0] = value[0].substring(1);
			if(value[1].equals("~")) f2 = true;
			value[1] = value[1].substring(1);
			if(value[2].equals("~")) f3 = true;
			value[2] = value[2].substring(1);
			if(value[3].equals("~")) f4 = true;
			value[3] = value[3].substring(1);
			if(f1) value[0] = "30";
			String hql;
			if(f2)
			{
				if(f3)
				{
					if(f4)
					{
						hql = "from TUserExam where userid = '" + value[0] + "'"; 
					}
					else
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate < '" + value[3] + "'"; 
					}
				}
				else
				{
					if(f4)
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate > '" + value[2] + "'"; 
					}
					else
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate < '" + value[3] + "' and takedate > '" + value[2] + "'"; 
					}
				}
			}
			
			else
			{
				if(f3)
				{
					if(f4)
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and TExam.name like '%" + value[1] + "%'"; 
					}
					else
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate < '" + value[3] + "' and TExam.name like '%" + value[1] + "%'"; 
					}
				}
				else
				{
					if(f4)
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate > '" + value[2] + "' and TExam.name like '%" + value[1] + "%'"; 

					}
					else
					{
						hql = "from TUserExam where userid = '" + value[0] + "' and takedate < '" + value[3] + "' and takedate > '" + value[2] + "' and TExam.name like '%" + value[1] + "%'"; 

					}
				}
			}
			org.hibernate.Query query = session.createQuery(hql);
			
			List<TUserExam> list =query.list();
			for(int i=0;i<list.size();++i){
				System.out.println(list.get(i).getTExam().getName());
			}			
			ActionContext.getContext().getValueStack().set("userId", value[0]);
			ActionContext.getContext().getValueStack().set("list", list);
			ActionContext.getContext().getValueStack().set("name", value[1]);
			ActionContext.getContext().getValueStack().set("start",value[2]);
			ActionContext.getContext().getValueStack().set("end", value[3]);
			session.close();
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	public String doSearch_in_table()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<exam_score> list = new LinkedList<>();
		try
		{
			String[] value = ks_cj.split(",");
			for(int i = 1;i < value.length;i++)
			{
				String temp[] = new String[2];
				temp = value[i].split(":");
//				for(int j = 0;j < temp.length;j++) System.out.println(temp[j] + " " + j);
				String hql = "select count(*) from TUserExam u where u.count>0 and examid = '" +temp[0] + "' and kscore+zscore > (select kscore + zscore from TUserExam where userid = '" + temp[1] + "' and examid = '" + temp[0] + "')";
				String hql_exam = "select name from TExam where id = '" + temp[0] + "'";
				String hql_max = "select max(kscore+zscore) from TUserExam where examid = '" + temp[0] + "'";
				String hql_min = "select min(kscore+zscore) from TUserExam where examid = '" + temp[0] + "'";
				String hql_cou = "select count(*) from TUserExam where examid = '" + temp[0] + "'";
				String hql_sco = "select kscore + zscore from TUserExam where userid = '" + temp[1] + "' and examid = '" + temp[0] + "'";
				org.hibernate.Query query = session.createQuery(hql);
				org.hibernate.Query query1 = session.createQuery(hql_exam);
				org.hibernate.Query query2 = session.createQuery(hql_max);
				org.hibernate.Query query3 = session.createQuery(hql_min);
				org.hibernate.Query query4 = session.createQuery(hql_cou);
				org.hibernate.Query query5 = session.createQuery(hql_sco);
				Object pos = ( (Object) ( (Long)query.list().get(0) + 1) );
				Object exam = query1.list().get(0);
				Object max = query2.list().get(0);
				Object min = query3.list().get(0);
				Object cou = query4.list().get(0);
				Object sco = query5.list().get(0);
				list.add(new exam_score(pos,exam,max,min,cou,sco));
			}
			ActionContext.getContext().getValueStack().set("list", list);
			session.close();
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	
	/**
	 *using to find paper
	 *get examid from jsp
	 *not paging
	 **/
	public String doSearch_paper()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		HttpServletRequest request=ServletActionContext.getRequest();
		// TODO Auto-generated method stub
		Transaction tx = null;
		userId = "30";
		Session session = factory.openSession();
		try
		{
			String hql = "select TPaper.name,examTime from TExam where id = '" + Exam_id + "'";
			ActionContext.getContext().getValueStack().set("Exam_id", Exam_id);
			org.hibernate.Query query = session.createQuery(hql);
			Object[] obje = (Object[]) query.list().get(0);
			ActionContext.getContext().getValueStack().set("name", obje[0]);
			ActionContext.getContext().getValueStack().set("time", obje[1]);
			System.out.println(query.list().get(0));
			
			hql = "select TPaper.id from TExam where id = '" + Exam_id + "'";
			query = session.createQuery(hql);
			Object paperId = query.list().get(0);
			ActionContext.getContext().getValueStack().set("paperId", query.list().get(0));
			
			hql = "select TQuestion.id from TPaperQuestion where TPaper.id = '" + paperId + "'";
			query = session.createQuery(hql);
			
			List<Object> list = new LinkedList<>();
			List<question> li = new LinkedList<>();
			list = query.list();
			for(int i = 0;i < list.size();i++)
			{
				hql = "select id,name,content,type,score from TQuestion where id = '" + list.get(i) + "' order by id";
				query = session.createQuery(hql);
				Object[] obj = (Object[]) query.list().get(0);
				li.add(new question(obj[0],obj[1],obj[2],obj[3],obj[4]));
			}
			ActionContext.getContext().getValueStack().set("list", li);
			session.close();
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	
	/**
	 * to judge the paper automatically and make grade
	**/
	public String doSearch_answer()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		HttpServletRequest request=ServletActionContext.getRequest();
		// TODO Auto-generated method stub
		Transaction tx = null;
		userId = "30";
		Paper_id = "1";
		Session session = factory.openSession();
		try
		{
			String[] value = kanswer.split("~");
			String[] value1 = zanswer.split("~");
			System.out.println(zanswer);
			System.out.println(value1.length);
			for(int i = 0;i < value1.length;i++){
				System.out.println(value1[i]);
				if(value1[i].equals("!!!")) value1[i] = "未答";
			}
			System.out.println(value.length);
			for(int i = 0;i < value.length;i++){
				System.out.println(value[i]);
				if(value[i].equals("E")) value[i] = "未答";
			}
			int posz,posk;
			posz = posk = 0;
			String hql = "select TQuestion.id from TPaperQuestion where TPaper.id = '" + Paper_id + "' order by id";
			org.hibernate.Query query = session.createQuery(hql);
			List<Object> list = new LinkedList<>();
			double kscore,zscore;
			kscore = zscore = 0;
			List<answer> li = new LinkedList<>();
			list = query.list();
			System.out.println(list.size());
			for(int i = 0;i < list.size();i++)
			{
				hql = "select id,type,answer,score,name,content from TQuestion where id = '" + list.get(i)+ "'";
				query = session.createQuery(hql);
				System.out.println(query.list().get(0));
				Object[] obj = (Object[]) query.list().get(0);
				System.out.println(obj[1]);
				if(obj[1].equals("简答题"))
				{
					String hqlzString = "update TUserExamQuestion Tues set Tues.answer = '" + value1[posz] + "' where id = "+obj[0] + " and TExam.id = " + Exam_id + " and TUser.id = "+ userId;
					session.createQuery(hqlzString).executeUpdate();
					
					
					double gscore = 0;
					similarString ss = new similarString();
					double dege = ss.SimilarDegree(value1[posz], (String)obj[2]);
					if(dege >= 0.7) 
					{
						zscore += (double)obj[3];
						gscore = (double)obj[3];
					}
					else if(dege <= 0.3){
						zscore += 0;
						gscore = 0;
					}
					else {
						zscore += (double)obj[3]*dege;
						gscore = (double)obj[3]*dege;
					}
					
					li.add(new answer(obj[0],obj[1],obj[2],obj[3],obj[4],obj[5],gscore,value1[posz]));
					posz++;
					
					hqlzString = "update TUserExamQuestion Tues set Tues.score = '" + gscore + "' where id = "+obj[0] + " and TExam.id = " + Exam_id + " and TUser.id = "+ userId;
					session.createQuery(hqlzString).executeUpdate();
					

			
				}
				else
				{
					String hqlkString = "update TUserExamQuestion Tues set Tues.answer = '" + value[posk] + "' where id = "+obj[0] + " and TExam.id = " + Exam_id + " and TUser.id = "+ userId;
					session.createQuery(hqlkString).executeUpdate();
					
					
					double gscore = 0;
					if(value[posk].equals((String)obj[2])){
						kscore += (double)obj[3];
						gscore = (double)obj[3];
					}
					else gscore = 0;
					
					li.add(new answer(obj[0],obj[1],obj[2],obj[3],obj[4],obj[5],gscore,value[posk]));
					posk++;
					
					hqlkString = "update TUserExamQuestion Tues set Tues.score = '" + gscore + "' where id = "+obj[0] + " and TExam.id = " + Exam_id + " and TUser.id = "+ userId;
					session.createQuery(hqlkString).executeUpdate();
					
				}
				
			}
			String hqlString = "update TUserExam Tue set Tue.zscore = '" + zscore + "' where TExam.id = " + Exam_id + " and TUser.id = "+ userId;
			String hqlkString = "update TUserExam Tue set Tue.kscore = '" + kscore + "' where TExam.id = " + Exam_id + " and TUser.id = "+ userId;
			String hqlcString = "update TUserExam Tue set Tue.count = Tue.count + 1 where TExam.id = " + Exam_id + " and TUser.id = "+ userId;
			session.createQuery(hqlString).executeUpdate();
			session.createQuery(hqlkString).executeUpdate();
			session.createQuery(hqlcString).executeUpdate();
			
			ActionContext.getContext().getValueStack().set("list", li);
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	public String doSearch_in_prepaper()
	{
		//factory = new Configuration().configure().buildSessionFactory();
		HttpServletRequest request=ServletActionContext.getRequest();
		// TODO Auto-generated method stub
		Transaction tx = null;
		userId = "30";
		Paper_id = "1";
		Session session = factory.openSession();
		try
		{
			String hql = "select TQuestion.id from TPaperQuestion where TPaper.id = '" + Paper_id + "' order by id";
			org.hibernate.Query query = session.createQuery(hql);
			List<Object> list = new LinkedList<>();
			double kscore,zscore;
			kscore = zscore = 0;
			List<answer> li = new LinkedList<>();
			list = query.list();
			System.out.println(list.size());
			for(int i = 0;i < list.size();i++)
			{
				hql = "select id,type,answer,score,name,content from TQuestion where id = '" + list.get(i)+ "'";
				query = session.createQuery(hql);
				Object[] obj = (Object[]) query.list().get(0);
				System.out.println(obj[1]);
				
				String hqlString = "select answer,score from TUserExamQuestion where TUser.id = " + userId + " and TQuestion.id=" + obj[0];
				query = session.createQuery(hqlString);
				Object[] obj1 = (Object[]) query.list().get(0);
				
				li.add(new answer(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj1[1], obj1[0]));
			}
			ActionContext.getContext().getValueStack().set("list", li);
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
	
	
	protected String getParam(String key){  
        return ServletActionContext.getRequest().getParameter(key);  
    }

	public String getKs_cj() {
		return ks_cj;
	}

	public void setKs_cj( String ks_cj) {
		this.ks_cj = ks_cj;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public String getExam_n_s_e() {
		return Exam_n_s_e;
	}

	public void setExam_n_s_e(String exam_n_s_e) {
		Exam_n_s_e = exam_n_s_e;
	}

	public String getExam_id() {
		return Exam_id;
	}

	public void setExam_id(String exam_id) {
		Exam_id = exam_id;
	}

	public String getKanswer() {
		return kanswer;
	}

	public void setKanswer(String kanswer) {
		this.kanswer = kanswer;
	}

	public String getZanswer() {
		return zanswer;
	}

	public void setZanswer(String zanswer) {
		this.zanswer = zanswer;
	}

	public String getPaper_id() {
		return Paper_id;
	}

	public void setPaper_id(String paper_id) {
		Paper_id = paper_id;
	}  
}

class exam_score
{
	public exam_score(Object pos,Object exam,Object max,Object min,Object cou,Object sco)
	{
		this.cou = cou;
		this.exam = exam;
		this.max = max;
		this.sco = sco;
		this.pos = pos;
		this.min = min;
	}


	public Object getPos() {
		return pos;
	}

	public void setPos(Object pos) {
		this.pos = pos;
	}

	public Object getExam() {
		return exam;
	}

	public void setExam(Object exam) {
		this.exam = exam;
	}

	public Object getMax() {
		return max;
	}

	public void setMax(Object max) {
		this.max = max;
	}

	public Object getMin() {
		return min;
	}

	public void setMin(Object min) {
		this.min = min;
	}

	public Object getCou() {
		return cou;
	}

	public void setCou(Object cou) {
		this.cou = cou;
	}

	public Object getSco() {
		return sco;
	}

	public void setSco(Object sco) {
		this.sco = sco;
	}
	Object pos,exam,max,min,cou,sco;
}


class question
{
	Object id,name,content,type,score;
	public question(Object id,Object name,Object content,Object type,Object score)
	{
		this.id = id;
		this.name = name;
		this.content = content;
		this.type = type;
		this.score = score;
	}
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Object getType() {
		return type;
	}
	public void setType(Object type) {
		this.type = type;
	}
	public Object getScore() {
		return score;
	}
	public void setScore(Object score) {
		this.score = score;
	}
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
}

class answer
{
	Object id,name,content,type,score,gscore,answer,zianswer;
	public answer(Object id,Object type,Object answer,Object score,Object name,Object content,Object gcore,Object zianswer)
	{
		this.id = id;
		this.name = name;
		this.content = content;
		this.answer = answer;
		this.type = type;
		this.score = score;
		this.gscore = gcore;
		this.zianswer = zianswer;
	}
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public Object getType() {
		return type;
	}
	public void setType(Object type) {
		this.type = type;
	}
	public Object getScore() {
		return score;
	}
	public void setScore(Object score) {
		this.score = score;
	}
	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public Object getGscore() {
		return gscore;
	}
	public void setGscore(Object gscore) {
		this.gscore = gscore;
	}
	public Object getAnswer() {
		return answer;
	}
	public void setAnswer(Object answer) {
		this.answer = answer;
	}
	public Object getZianswer() {
		return zianswer;
	}
	public void setZianswer(Object zianswer) {
		this.zianswer = zianswer;
	}
}




class similarString
{
	public similarString(){}
	public double SimilarDegree(String strA, String strB){  
		  
	    String newStrA = removeSign(strA);  

	    String newStrB = removeSign(strB);  

	    int temp = Math.max(newStrA.length(), newStrB.length());  

	    int temp2 = longestCommonSubstring(newStrA, newStrB).length();  

	    return temp2 * 1.0 / temp;  

	}  

	  

	private static String removeSign(String str) {  

	    StringBuffer sb = new StringBuffer();  

	    for (char item : str.toCharArray())  

	        if (charReg(item)){  

	            //System.out.println("--"+item);  

	            sb.append(item);  

	        }  

	    return sb.toString();  

	}  



	private static boolean charReg(char charValue) {  

	    return (charValue >= 0x4E00 && charValue <= 0X9FA5)  

	            || (charValue >= 'a' && charValue <= 'z')  

	            || (charValue >= 'A' && charValue <= 'Z')  

	            || (charValue >= '0' && charValue <= '9');  

	}  



	private static String longestCommonSubstring(String strA, String strB) {  

	    char[] chars_strA = strA.toCharArray();  

	    char[] chars_strB = strB.toCharArray();  

	    int m = chars_strA.length;  

	    int n = chars_strB.length;  

	    int[][] matrix = new int[m + 1][n + 1];  

	    for (int i = 1; i <= m; i++) {  

	        for (int j = 1; j <= n; j++) {  

	            if (chars_strA[i - 1] == chars_strB[j - 1])  

	                matrix[i][j] = matrix[i - 1][j - 1] + 1;  

	            else  

	                matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);  

	        }  

	    }  

	    char[] result = new char[matrix[m][n]];  

	    int currentIndex = result.length - 1;  

	    while (matrix[m][n] != 0) {  

	        if (matrix[n] == matrix[n - 1])  

	            n--;  

	        else if (matrix[m][n] == matrix[m - 1][n])   

	            m--;  

	        else {  

	            result[currentIndex] = chars_strA[m - 1];  

	            currentIndex--;  

	            n--;  

	            m--;  

	        }  
	    }  

	    return new String(result);  

	}  

	}  






