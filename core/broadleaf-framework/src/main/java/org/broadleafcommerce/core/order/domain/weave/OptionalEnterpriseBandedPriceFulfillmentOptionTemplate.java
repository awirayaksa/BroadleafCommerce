/*
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2015 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.broadleafcommerce.core.order.domain.weave;

import org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentPriceBand;
import org.broadleafcommerce.core.order.fulfillment.domain.FulfillmentPriceBandImpl;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

/**
 * This class is meant as a template to provide overriding of the annotations on fields in 
 * <code>org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl</code>.  This provides a 
 * stop gap measure to allow someone to weave in the appropriate annotations in 4.0.x without forcing a schema change on those 
 * who prefer not to use it.  This should likely be removed in 4.1 for fixed annotations on the entity itself.
 * 
 * @author Kelly Tisdell
 *
 */
public abstract class OptionalEnterpriseBandedPriceFulfillmentOptionTemplate {

    @OneToMany(mappedBy = "option", targetEntity = FulfillmentPriceBandImpl.class)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "blStandardElements")
    protected List<FulfillmentPriceBand> bands = new ArrayList<FulfillmentPriceBand>();

}
