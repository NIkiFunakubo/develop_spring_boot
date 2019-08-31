/*
package com.example.powerwords.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

public class AppConfig implements Config {

    private DataSource dataSource;
       private Dialect dialect;
       private SqlFileRepository sqlFileRepository;

       @Override
       public DataSource getDataSource() {
           return new TransactionAwareDataSourceProxy(dataSource);
       }

       public void setDataSource(DataSource dataSource) {
           this.dataSource = dataSource;
       }

       @Override
       public Dialect getDialect() {
           return dialect;
       }

       public void setDialect(Dialect dialect) {
           this.dialect = dialect;
       }

       @Override
       public SqlFileRepository getSqlFileRepository() {
           return sqlFileRepository;
       }

       public void setSqlFileRepository(SqlFileRepository sqlFileRepository) {
           this.sqlFileRepository = sqlFileRepository;
       }
}
*/