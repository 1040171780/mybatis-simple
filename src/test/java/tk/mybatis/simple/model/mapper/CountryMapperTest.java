package tk.mybatis.simple.model.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest extends BaseMapperTest{

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

    public static void main(String[] args) {
        double x = 10000.0 /3;
        System.out.println(x);
        System.out.printf("%8.2f", x);
        System.out.println();
        System.out.printf("%-8.2f", x);
        System.out.println();
        System.out.printf("%,.2f", 10000.0 / 3.0);
        System.out.println();
        System.out.printf("%,.2f", 100000.0 / 3.0);
        System.out.println();
        System.out.println();
        System.out.printf("%,.2f", 10000.0 / 3.0);
        System.out.printf("%,(.2f", 10000.0 / 3.0);
    }

}
