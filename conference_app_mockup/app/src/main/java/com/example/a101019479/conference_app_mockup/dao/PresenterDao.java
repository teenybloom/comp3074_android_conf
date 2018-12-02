package com.example.a101019479.conference_app_mockup.dao;

import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.List;

public interface PresenterDao {
    public void addPresenter(Presenter presenter);
    public List<Presenter> getAllPresenters();
}
