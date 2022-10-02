package dataPkg;

import org.testng.annotations.DataProvider;

public class SearchFunctionalityData {
	
	@DataProvider
	public String[] negativeSearchData() {
		String[] data = {	"#*&#*()$KFNLKDFNDLKFNDLKFNLKNq092472834723894738924732894",
							"#*&#*()$KFNLKDFNDLKFNDLKFNLKNq092472834723894738924732894"};
		return data;
	}
	
	@DataProvider
	public String[] positiveSearchFunctionalityData() {
		String[] data = {"apple", "samsung", "lg"};
		return data;
	}

}
