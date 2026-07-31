package com.example.Splimate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SettlementController {
@Autowired
SettlementService settleservice;

@GetMapping("/settlementcalculate")
public String calcultae(@RequestParam Long groupId) {
return settleservice.calculateSettlement(groupId);	
}
}
