package com.example.ex9baitap1.repository;

import com.example.ex9baitap1.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {
}
