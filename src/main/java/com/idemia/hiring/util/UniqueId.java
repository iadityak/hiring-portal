/**
 * 
 */
package com.idemia.hiring.util;

import java.util.UUID;

/**
 * 
 *@author G521774 (aditya.kumar@idemia.com)
 *  
 */
public class UniqueId {
	public String UniqueId() {
		return UUID.randomUUID().toString();
	}
}