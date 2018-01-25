import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");
    String[] filter=CategoryName.split(",");
    String Pname=filter[1];
    String Ptype=filter[0];

		HashMap<String, Product> hm = new HashMap<String, Product>();
		if (Pname.equals("null")){
			hm.putAll(SAXParserXMLDataStore.products);
			name = "";
		}
		else{
      if(Ptype.equals("laptop")){
			if (Pname.equals("Apple")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Apple") && entry.getValue().getType().equals("laptop") ){
						hm.put(entry.getKey(),entry.getValue());
						name = "Apple";
					}

				}
			}
			if (Pname.equals("Dell")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Dell") && entry.getValue().getType().equals("laptop")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Dell";
					}

				}
			}
			if (Pname.equals("HP")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("HP") && entry.getValue().getType().equals("laptop")){
						hm.put(entry.getKey(),entry.getValue());
						name = "HP";
					}

				}
			}
			if (Pname.equals("Lenovo")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Lenovo") && entry.getValue().getType().equals("laptop")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Lenovo";
					}

				}
			}
    }
    if(Ptype.equals("phone")){
    if (Pname.equals("Apple")){
      for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()) {
        if (entry.getValue().getRetailer().equals("Apple") && entry.getValue().getType().equals("phone")){
          hm.put(entry.getKey(),entry.getValue());
          name = "Apple";
        }

      }
    }
    if (Pname.equals("Samsung")){
      for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
        if (entry.getValue().getRetailer().equals("Samsung") && entry.getValue().getType().equals("phone")){
          hm.put(entry.getKey(),entry.getValue());
          name = "Samsung";
        }

      }
    }
    if (Pname.equals("Sony")){
      for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
        if (entry.getValue().getRetailer().equals("Sony") && entry.getValue().getType().equals("phone")){
          hm.put(entry.getKey(),entry.getValue());
          name = "Sony";
        }

      }
    }
    if (Pname.equals("Moto")){
      for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
        if (entry.getValue().getRetailer().equals("Moto") && entry.getValue().getType().equals("phone")){
          hm.put(entry.getKey(),entry.getValue());
          name = "Moto";
        }

      }
    }
  }
  if(Ptype.equals("watch")){
  if (Pname.equals("Apple")){
    for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()) {
      if (entry.getValue().getRetailer().equals("Apple") && entry.getValue().getType().equals("watch")){
        hm.put(entry.getKey(),entry.getValue());
        name = "Apple";
      }

    }
  }
  if (Pname.equals("Samsung")){
    for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
      if (entry.getValue().getRetailer().equals("Samsung") && entry.getValue().getType().equals("watch")){
        hm.put(entry.getKey(),entry.getValue());
        name = "Samsung";
      }

    }
  }
  if (Pname.equals("Sony")){
    for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
      if (entry.getValue().getRetailer().equals("Sony") && entry.getValue().getType().equals("watch")){
        hm.put(entry.getKey(),entry.getValue());
        name = "Sony";
      }

    }
  }
  if (Pname.equals("Moto")){
    for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
      if (entry.getValue().getRetailer().equals("Moto") && entry.getValue().getType().equals("watch")){
        hm.put(entry.getKey(),entry.getValue());
        name = "Moto";
      }

    }
  }
}

if(Ptype.equals("speaker")){
if (Pname.equals("JBL")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()) {
    if (entry.getValue().getRetailer().equals("JBL") && entry.getValue().getType().equals("speaker")){
      hm.put(entry.getKey(),entry.getValue());
      name = "JBL";
    }

  }
}
if (Pname.equals("Bose")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Bose") && entry.getValue().getType().equals("speaker")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Bose";
    }

  }
}
if (Pname.equals("Philips")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Philips") && entry.getValue().getType().equals("speaker")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Philips";
    }

  }
}
if (Pname.equals("Logitech")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Logitech") && entry.getValue().getType().equals("speaker")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Logitech";
    }

  }
}
}

if(Ptype.equals("headphone")){
if (Pname.equals("Beats")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()) {
    if (entry.getValue().getRetailer().equals("Beats") && entry.getValue().getType().equals("headphone")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Beats";
    }

  }
}
if (Pname.equals("Bose")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Bose") && entry.getValue().getType().equals("headphone")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Bose";
    }

  }
}
if (Pname.equals("Sony")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Sony") && entry.getValue().getType().equals("headphone")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Sony";
    }

  }
}
if (Pname.equals("Skullcandy")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Skullcandy") && entry.getValue().getType().equals("headphone")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Skullcandy";
    }

  }
}
}
if(Ptype.equals("storage")){
if (Pname.equals("Seagate")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()) {
    if (entry.getValue().getRetailer().equals("Seagate") && entry.getValue().getType().equals("storage")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Seagate";
    }

  }
}
if (Pname.equals("Samsung")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("Samsung") && entry.getValue().getType().equals("storage")){
      hm.put(entry.getKey(),entry.getValue());
      name = "Samsung";
    }

  }
}
if (Pname.equals("WD")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("WD") && entry.getValue().getType().equals("storage")){
      hm.put(entry.getKey(),entry.getValue());
      name = "WD";
    }

  }
}
if (Pname.equals("SanDisk")){
  for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
    if (entry.getValue().getRetailer().equals("SanDisk") && entry.getValue().getType().equals("storage")){
      hm.put(entry.getKey(),entry.getValue());
      name = "SanDisk";
    }

  }
}
}

	}

		Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");

		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		pw.print("No of match:"+size);
		for (Map.Entry<String, Product> entry : hm.entrySet()) {
			Product product = entry.getValue();
			if (i == 1 || (i % 3 == 1 && i <= size))
				pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + product.getName() + "</h3>");


			pw.print("<strong>RETAILER:" + product.getRetailer() + "</strong><br>");
			pw.print("<strong>PRICE: $" + product.getPrice() + "</strong><ul style='margin-left: 0px;'>");

			pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+product.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" + "<input type='hidden' name='name' value='"
					+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
					+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='submit' value='Add to Cart' ></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewItem'>" + "<input type='hidden' name='name' value='"
					+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
					+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='submit' value='View Item'></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='WriteReview'>" + "<input type='hidden' name='name' value='"
					+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
					+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='submit' value='Write Review'></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewReview'>" + "<input type='hidden' name='name' value='"
					+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
					+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='submit' value='View Review'></form></li>");
			pw.print("</ul></div></td>");
			i++;
			if (i % 3 == 1) {
				pw.print("</tr>");
				if (i <=size)
					pw.print("<tr>");

			}
		}

		pw.print("</table></div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}

}
