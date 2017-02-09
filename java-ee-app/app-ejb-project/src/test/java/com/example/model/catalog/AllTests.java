package com.example.model.catalog;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.model.catalog.AddressTest;
import com.example.model.catalog.AlbumTest;
import com.example.model.catalog.ArtistTest;
import com.example.model.catalog.BookTest;
import com.example.model.catalog.CustomerTest;
import com.example.model.catalog.NewsLetterTest;
import com.example.model.catalog.OrderTest;
import com.example.model.catalog.StaffMemberTest;
import com.example.model.catalog.TrackTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AlbumTest.class,
    AddressTest.class,
    ArtistTest.class,
    BookTest.class,
    CustomerTest.class,
    NewsLetterTest.class,
    OrderTest.class,
    StaffMemberTest.class,
    TrackTest.class
})
public class AllTests {

}
