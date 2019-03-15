package com.idemia.hiring.constants;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         This interface contain constants that are used through the
 *         application.
 *
 */
public interface AppConstants {

	String comapnyName = "IDEMIA";
	String candFeedbackEmailSubject = "Share your feedback of Interview Round ";
	String jwtSecretKey = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";
	String jwtIssuer = "hiringportal.com";
	String candFeedMailBody = "Dear {name}, Thank you for the opportunity to interview for the position {position} with the {company}.I truly appreciate your time and consideration!. Click on the link to share your feedback  ";
	String localEnvBaseUrl = "http://localhost:8080";
	String returnFeedFormUrl = "/api/candidate/feedback/returnfeedbackform?jwtToken=";
}
