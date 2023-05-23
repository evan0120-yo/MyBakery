package com.example.table.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> add(){
		Product product = new Product();
		productService.save(product);
		return ResponseEntity.status(200).body("test success");
	}
	
//	@PostMapping
//	public ResponseEntity<?> countProduct(String[] products){
////		此 function 會收到一個字串的陣列，每個字串代表依序販售出去的商品，一個字串代表一個數量。
////		例如陣列 [  “mouse”,  “notebook”, “keyboard”, “notebook”,“keyboard”, “notebook”] 
////				代表賣出 notebook 三件，keyboard 兩件, mouse 一件。商品種類不限於只有 notebook, keyboard, mouse 三種。
//		Set<Map<String,List<String>>> productSet = new HashSet<Map<String,List<String>>>();
//		for(String product : products) {
//			if(productSet.isEmpty()) {
//				Map<String,List<String>> productMap = new HashMap<String,List<String>>();
//				List<String> productList = new ArrayList<String>();
//				productList.add(product);
//				productMap.put(product, productList);
//				productSet.add(productMap);
//			} else {
//				for(Map<String,List<String>> productMap : productSet) {
//					for(String productString : productMap.keySet()) {
//						Boolean check = false;
//						List<String> productList;
//						if(productString.equals(product)) {
//							productList = productMap.get(productString);
//							productList.add(product);
//							check = true;
//						}
//						if(!check) {
//							productList = new ArrayList<String>();
//							productList.add(product);
//							productMap.put(product, productList);
//						}
//					}
//				}
//			}
//		}
////		此 function 會依照銷售數量的多寡，來印出商品名稱和賣出去的數量。以上為例，會印出：
////		notebook 3
////		keyboard 2
////		mouse 1
//		Map<String, Integer> returnMap = new HashMap<String, Integer>();
//		for(Map<String,List<String>> product : productSet) {
//			for(String productString : product.keySet()) {
//				returnMap.put(productString, product.get(productString).size());
//			}
//		}
//		return ResponseEntity.status(200).body(returnMap);
//	}
//
//	@GetMapping
//	public ResponseEntity<?> testApi(){
//        
//		return ResponseEntity.status(200).body("test success");
//	}
}
