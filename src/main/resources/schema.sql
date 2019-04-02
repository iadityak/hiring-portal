DROP PROCEDURE IF EXISTS `get_cand_on_status` ^;
CREATE  PROCEDURE `get_cand_on_status`(IN candStatus varchar(45) , IN startDate varchar(45), IN endDate varchar(45))
BEGIN SELECT
candidate.first_name  AS firstName,  
candidate.last_name AS lastName,      
candidate.phone_number  AS phoneNumber,        
candidate.email AS email,        
candidate.skill_set AS skillSet,        
candidate.experience_years AS experienceYears,        
candidate.online_score AS onlineScore       
FROM candidate candidate WHERE candidate.status = candStatus
AND candidate.date_of_enrollment > startDate
AND candidate.date_of_enrollment < endDate;
END ^;