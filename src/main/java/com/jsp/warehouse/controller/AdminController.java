package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveSuperAdmin(@RequestBody AdminRequest adminRequest){
		return adminService.saveSuperAdmin(adminRequest);
	}

	@PreAuthorize("hasAuthority('CREATE_ADMIN')")
	@PostMapping("warehouse/{warehouseId}/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmins(@RequestBody AdminRequest  adminRequest,@PathVariable int warehouseId){
		return adminService.createAdmins(adminRequest,warehouseId);
	}
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>>  updateAdimin(@RequestBody AdminRequest adminRequest){
		return adminService.UpdateAdimin(adminRequest);
	}
	
}