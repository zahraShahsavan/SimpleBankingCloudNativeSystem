package com.example.ui.dto.request;

import com.example.ui.model.EAccount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAccountListRequest {
    List<EAccount> accountList;

    public GetAccountListRequest() {
        this.accountList = new ArrayList<>();
    }
}
