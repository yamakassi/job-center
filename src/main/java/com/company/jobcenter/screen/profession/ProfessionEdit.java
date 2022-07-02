package com.company.jobcenter.screen.profession;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Profession;

@UiController("Profession.edit")
@UiDescriptor("profession-edit.xml")
@EditedEntityContainer("professionDc")
public class ProfessionEdit extends StandardEditor<Profession> {
}