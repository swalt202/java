package com.emailer.inter;

import com.emailer.fields.Fields;

import java.util.List;

public interface Inter {
      List<Fields> selectByTable(String table);

}
