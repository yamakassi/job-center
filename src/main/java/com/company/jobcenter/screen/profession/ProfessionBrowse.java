package com.company.jobcenter.screen.profession;

import io.jmix.ui.screen.*;
import com.company.jobcenter.entity.Profession;

@UiController("Profession.browse")
@UiDescriptor("profession-browse.xml")
@LookupComponent("professionsTable")
public class ProfessionBrowse extends StandardLookup<Profession> {
}