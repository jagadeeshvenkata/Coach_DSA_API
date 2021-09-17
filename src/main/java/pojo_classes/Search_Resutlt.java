package pojo_classes;

import java.util.List;

public class Search_Resutlt {

	
		 private List<String> products;
		 private String categories;
		 private String refinements;
		 private String keywords;
		 private String preferences;
		 private Autoselect autoselect;
		 private String suggestions;
		 private int totalProducts;
		 private String conversation;
		public List<String> getProducts() {
			return products;
		}
		public void setProducts(List<String> products) {
			this.products = products;
		}
		public String getCategories() {
			return categories;
		}
		public void setCategories(String categories) {
			this.categories = categories;
		}
		public String getRefinements() {
			return refinements;
		}
		public void setRefinements(String refinements) {
			this.refinements = refinements;
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public String getPreferences() {
			return preferences;
		}
		public void setPreferences(String preferences) {
			this.preferences = preferences;
		}
		public Autoselect getAutoselect() {
			return autoselect;
		}
		public void setAutoselect(Autoselect autoselect) {
			this.autoselect = autoselect; 
		}
		public String getSuggestions() {
			return suggestions;
		}
		public void setSuggestions(String suggestions) {
			this.suggestions = suggestions;
		}
		public int getTotalProducts() {
			return totalProducts;
		}
		public void setTotalProducts(int totalProducts) {
			this.totalProducts = totalProducts;
		}
		public String getConversation() {
			return conversation;
		}
		public void setConversation(String conversation) {
			this.conversation = conversation;
		}
	
	
	
	
	
	
}
